# test_github_actions
follow the quickstart for GitHubActions

LessonsLearned:
- each workflow can contains out of several jobs. A job has several steps, startet each with a 'hyphen'. A step contains either a single 'uses' or a 'run' keyword. It optionally can also include a 'name'.

- you can add branch rules to enable blocking of PR merging if workflow is not passed. Took some time to understand that there was an interferece with a second workflow which added a commit but did not run the needed workflow again. Disabling helped, will figure out later how to deal with this. Guess I have to trigger the build.. workflow also on push.
