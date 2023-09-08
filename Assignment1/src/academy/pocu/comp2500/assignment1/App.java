package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        registry.registerBlogCreator("Blog");
        registry.registerTagFilterSetter("Blog", "setTagFilterOn");
        registry.registerAuthorFilterSetter("Blog", "setAuthorFilterOn");
        registry.registerPostOrderSetter("Blog", "sortArticles");
        registry.registerPostListGetter("Blog", "getArticles");
        registry.registerPostAdder("Blog", "addArticle");
        registry.registerPostTitleUpdater("Article", "updateTitle");
        registry.registerPostBodyUpdater("Article", "updateBody");
        registry.registerPostTagAdder("Article", "addTag");
        registry.registerCommentAdder("Article", "addComment");
        registry.registerSubcommentAdder("Comment", "addSubComment");
        registry.registerCommentUpdater("Comment", "updateComment");
        registry.registerSubcommentUpdater("Comment", "updateSubComment");
        registry.registerReactionAdder("Article", "addReaction");
        registry.registerReactionRemover("Article", "removeReaction");
        registry.registerCommentUpvoter("Comment", "addUpVote");
        registry.registerCommentDownvoter("Comment", "addDownVote");
        registry.registerCommentListGetter("Article", "getComments");
        registry.registerSubcommentListGetter("Comment", "getSubComments");
        registry.registerSubcommentUpvoter("Comment", "addUpVote");
        registry.registerSubcommentDownvoter("Comment", "addDownVote");
    }
}
