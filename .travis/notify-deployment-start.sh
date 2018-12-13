#!/bin/bash

# Create a deployment
create_gh_deployment () {
  curl -s -X POST "https://api.github.com/repos/${TRAVIS_REPO_SLUG}/deployments" \
      -H 'Content-Type: application/json' \
      -H 'Accept: application/vnd.github.ant-man-preview+json' \
      -H "Authorization: token ${GITHUB_ACCESS_TOKEN}" \
      -d "{\"ref\": \"${TRAVIS_COMMIT}\", \"environment\": \"production\", \"required_contexts\": [], \"auto_merge\": false}"
}

declare -r created_gh_deployment=$(create_gh_deployment)
GH_DEPLOYMENT_ID=$(echo $created_gh_deployment | jq .id)
echo "Created deployment with id $GH_DEPLOYMENT_ID."
echo $GH_DEPLOYMENT_ID > .gh_deployment_id
