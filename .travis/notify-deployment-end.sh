#!/bin/bash

# Notify GitHub of a successful deployment
notify_gh_about_a_deployment () {
  declare -r deployment_status=${2}
  curl -s -X POST "https://api.github.com/repos/${TRAVIS_REPO_SLUG}/deployments/${TRAVIS_COMMIT}/statuses" \
    -H 'Content-Type: application/json' \
    -H 'Accept: application/vnd.github.ant-man-preview+json' \
    -H "Authorization: token ${GITHUB_ACCESS_TOKEN}" \
    -d "{\"state\": \"${deployment_status}\", \"log_url\": \"${TRAVIS_BUILD_WEB_URL}\"}"
}


if [[ $TRAVIS_TEST_RESULT -eq 0 ]]
then
   status = "success"
else
   status = "error"
fi

notify_gh_about_a_deployment $status
