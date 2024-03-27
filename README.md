# test_github_actions
follow the quickstart for GitHubActions

LessonsLearned:
- each workflow can contains out of several jobs. A job has several steps, startet each with a 'hyphen'. A step contains either a single 'uses' or a 'run' keyword. It optionally can also include a 'name'.

 ok, now I have a workflow, running on manual or PR, building SW, running SW and running Unit tests, ok so far. What does not work, PR is only aborted if build is not working, but not if unittests are failing.
 You can see the failed job, but PR is possible -> Rework workflow to multible jobs which depend on each other, hope is that PR can only be merged if all jobs are successfull.
