#!/bin/sh

if [ "$TRAVIS_BRANCH" = "main" ] && [ "$TRAVIS_PULL_REQUEST" = false ]; then
  echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
  echo "Current image: $IMAGE:$TRAVIS_BRANCH"

  docker build \
  --tag "$IMAGE:$TRAVIS_BRANCH" \
  --build-arg "branch=$TRAVIS_BRANCH" \
  --build-arg "commit=$TRAVIS_COMMIT" \
  --build-arg "commit_message=$TRAVIS_COMMIT_MESSAGE" \
  --build-arg "tag=$TRAVIS_TAG" \
  .
  docker push "$IMAGE:$TRAVIS_BRANCH"
fi