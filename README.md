# GSoC-Android
Unofficial Google Summer of Code Companion app


## About GSOC
The Google Summer of Code, often abbreviated to GSoC, is an international annual program,in which Google awards stipends, which depends on the purchasing power parity of the country the student's university belongs to,[2] to all students who successfully complete a requested free and open-source software coding project during the summer. The program is open to university students aged 18 or over.

## Set up for Developers
1. Make sure you have downloaded the latest version of [Android Studio](https://developer.android.com/studio/index.html). It works on Linux, Windows and Mac. Download the correct version for your OS.
2. Go to [the project repo](https://github.com/coding-blocks/GSoC-Info-Android) and fork it by clicking "Fork".
3. If you are working on Windows, download [Git Bash for Windows](https://git-for-windows.github.io/) to get a full Unix bash with Git functionality
4. Clone the repo to your desktop git clone https://github.com/YOUR-USERNAME/GSoC-Info-Android.git
5. Initialize Git. `git init`
6. Open the project with Android Studio

## Configure remotes
When a repository is cloned, it has a default remote called `origin` that points to your fork on GitHub, not the original repository it was forked from. To keep track of the original repository, you should add another remote named `upstream`:

1. Open terminal or git bash in your local repository and set up the origin:

   `git remote add origin https://github.com/YOUR-USERNAME/GSoC-Info-Android.git`

2. Set the `upstream`:

   `git remote add upstream https://github.com/coding-blocks/GSoC-Info-Android.git`
  
3. Run `git remote -v` to check the status, you should see something like the following:

  > origin    https://github.com/YOUR_USERNAME/GSoC-Info-Android.git (fetch)
  
  > origin    https://github.com/YOUR_USERNAME/GSoC-Info-Android.git (push)
  
  > upstream  https://github.com/coding-blocks/GSoC-Info-Android.git (fetch)
  
  > upstream  https://github.com/coding-blocks/GSoC-Info-Android.git (push)

4. To update your local copy with remote changes, run the following:

   `git fetch upstream`

   `git merge upstream/master`

   This will give you an exact copy of the current remote, make sure you don't have any local changes.


## Contributing and developing a feature
1. Make sure you are in the master branch `git checkout master`
1. Sync your copy `git pull`
1. Create a new branch with a meaningful name `git checkout -b branch_name`
1. Develop your feature on Android Studio and run it using the emulator or connecting your own Android device
1. Clean your project from Android Studio `Build/Clean project`
1. Add the files you changed `git add file_name` (avoid using `git add .`)
1. Commit your changes `git commit -m "Message briefly explaining the feature"`
1. Keep one commit per feature. If you forgot to add changes, you can edit the previous commit `git commit --amend`
1. Push to your repo `git push origin branch-name`
1. Go into [the Github repo](https://github.com/coding-blocks/GSoC-Info-Android) and create a pull request explaining your changes
1. If you are requested to make changes, edit your commit using `git commit --amend`, push again and the pull request will edit automatically
1. You will need to add a message on the pull request notifying your changes to your reviewer

## Prerequisites  
This project uses following libraries, It is advisable to have a basic understanding of their implementation. 
* Picasso
* Room Persistant library
* Gson
* [TimeLineView](https://github.com/vipulasri/Timeline-View) 
* TapTargetView
* Paging Library

## Contribution Guidelines

* Pick an open issue from the [issue list](https://github.com/coding-blocks/GSoC-Info-Android/issues), claim it in the comments,after approval fix the issue and send us a pull request.
* Create a new issue,a community member will get back to you and once approved send the PR for the same
* Please go through our issue list first(open as well as closed) and make sure the issues you are reporting do not replicate the issues already reported. If you have issues on multiple pages, report them separately. Do not combine them into a single issue.
* All the PR’s need to be sent to the develop branch

## Avoid doing the following mistakes
1. Fix a new issue and submit a PR without reporting and getting it approved at first.
1. Fix an issue assigned to somebody else and submit a PR before the assignee does.
1. Report issues which are previously reported by others. (Please check the closed issues too before you report an issue).