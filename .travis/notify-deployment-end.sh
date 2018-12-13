#!/bin/bash

# Notify GitHub of a successful deployment
notify_gh_about_a_deployment () {
  declare -r deployment_id=${1}
  declare -r deployment_status=${2}
  curl -s -X POST "https://api.github.com/repos/${TRAVIS_REPO_SLUG}/deployments/${deployment_id}/statuses" \
    -H 'Content-Type: application/json' \
    -H 'Accept: application/vnd.github.ant-man-preview+json' \
    -H "Authorization: token ${GITHUB_ACCESS_TOKEN}" \
    -d "{\"state\": \"${deployment_status}\", \"log_url\": \"${TRAVIS_BUILD_WEB_URL}\"}"
}

if [[ $TRAVIS_TEST_RESULT -eq 0 ]]
then
   DEPLOYMENT_STATUS="success"
else
   DEPLOYMENT_STATUS="error"
fi

GH_DEPLOYMENT_ID=$(cat .gh_deployment_id)
echo "Updating deployment $GH_DEPLOYMENT_ID with status: $DEPLOYMENT_STATUS."
notify_gh_about_a_deployment $GH_DEPLOYMENT_ID $DEPLOYMENT_STATUS
