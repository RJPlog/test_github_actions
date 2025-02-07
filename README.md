# test_github_actions
follow the quickstart for GitHubActions

LessonsLearned:
- each workflow can contains out of several jobs. A job has several steps, startet each with a 'hyphen'. A step contains either a single 'uses' or a 'run' keyword. It optionally can also include a 'name'.

- you can add branch rules to enable blocking of PR merging if workflow is not passed. Took some time to understand that there was an interferece with a second workflow which added a commit but did not run the needed workflow again. Disabling helped, will figure out later how to deal with this. Guess I have to trigger the build.. workflow also on push.

- workflows per default have a timeout of 72h, but each step has a default timeout of 6h! -> you can set timeout of a step by using 'timeout-minutes: 4320  # Set the timeout to 72 hours (4320 minutes)'  -> next day copilot reverted his proposal, looks like still there only 6h possible in a single step which can not be increased
