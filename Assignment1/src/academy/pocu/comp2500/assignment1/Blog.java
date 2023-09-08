package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Blog {
    private final ArrayList<Article> articles;
    private final ArrayList<Article> filteredArticles;

    private boolean tagFiltered;
    private boolean authorFiltered;
    private boolean sortFilter;

    public Blog(User user) {
        articles = new ArrayList<>();
        filteredArticles = new ArrayList<>();
    }

    public ArrayList<Article> getArticles() {
        if (tagFiltered || authorFiltered) {
            return new ArrayList<>(filteredArticles);
        }
        if (!sortFilter) {
            articles.sort(byCreatedTimeDesc);
        }
        return new ArrayList<>(articles);
    }
    public Article getArticle(int postId) {
        return this.articles.get(postId);
    }


    Comparator<Article> byCreatedTimeDesc = new Comparator<Article>() {
        @Override
        public int compare(Article a1, Article a2) {
            return a2.getCreatedDateTime().compareTo(a1.getCreatedDateTime());
        }
    };
    Comparator<Article> byCreatedTime = new Comparator<Article>() {
        @Override
        public int compare(Article a1, Article a2) {
            return a1.getCreatedDateTime().compareTo(a2.getCreatedDateTime());
        }
    };
    Comparator<Article> byModifiedTimeDesc = new Comparator<Article>() {
        @Override
        public int compare(Article a1, Article a2) {
            return a2.getModifiedDateTime().compareTo(a1.getModifiedDateTime());
        }
    };
    Comparator<Article> byModifiedTime = new Comparator<Article>() {
        @Override
        public int compare(Article a1, Article a2) {
            return a1.getModifiedDateTime().compareTo(a2.getModifiedDateTime());
        }
    };
    Comparator<Article> byTitle = new Comparator<Article>() {
        @Override
        public int compare(Article a1, Article a2) {
            return a1.getTitle().compareTo(a2.getTitle());
        }
    };

    public void sortArticles(SortingMethod sortingType) {
        switch (sortingType) {
            case BY_CREATED_TIME:
                articles.sort(byCreatedTime);
                break;
            case BY_CREATED_TIME_DESC:
                articles.sort(byCreatedTimeDesc);
                break;
            case BY_MODIFIED_TIME:
                articles.sort(byModifiedTime);
                break;
            case BY_MODIFIED_TIME_DESC:
                articles.sort(byModifiedTimeDesc);
                break;
            case BY_TITLE:
                articles.sort(byTitle);
                break;
            case OFF:
                sortFilter = false;
                return;
            default:
                assert (false) : "Just 5 method";
                break;
        }
        sortFilter = true;
    }

    public void setTagFilterOn(String tag) {
        filterByTag(tag);
    }
    public void setAuthorFilterOn(String name) {
        filterByAuthor(name);
    }

    public void removeFilter() {
        filteredArticles.clear();
        authorFiltered = false;
        tagFiltered = false;
    }

    public void addArticle(User user, String title, String body) {
        Article newArticle = new Article(user, title, body);
        articles.add(0, newArticle);
    }

    private void filterByTag(String tag) {
        assert (tag != null) : "input is null";

        if (this.authorFiltered) {
            for (int i = 0; i < filteredArticles.size(); ++i) {
                Article article = filteredArticles.get(i);
                HashSet<String> tags = article.getTagsOrNull();

                if (!tags.contains(tag)) {
                    filteredArticles.remove(i);
                    --i;
                }
            }
        } else if (this.tagFiltered) {
            for (Article article : articles) {
                HashSet<String> tags = article.getTagsOrNull();

                if (tags.contains(tag) && !(filteredArticles.contains(article))) {
                    filteredArticles.add(article);
                }
            }
        } else {
            for (Article article : articles) {
                HashSet<String> tags = article.getTagsOrNull();

                if (tags.contains(tag)) {
                    filteredArticles.add(article);
                }
            }
        }
        this.tagFiltered = true;
    }
    private void filterByAuthor(String name) {
        assert (name != null) : "input is Null";

        if (this.authorFiltered) {
            filteredArticles.clear();
            return;
        }

        if (this.tagFiltered) {

            for (int i = 0; i < filteredArticles.size(); ++i) {
                Article article = filteredArticles.get(i);
                if (!(article.getAuthor().equals(name))) {
                    filteredArticles.remove(i);
                    --i;
                }
            }
        } else {
            for (Article article : articles) {
                if (article.getAuthor().equals(name)) {
                    filteredArticles.add(article);
                }
            }
        }
        this.authorFiltered = true;
    }
}
