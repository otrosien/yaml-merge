#!/bin/bash

set -e # Exit with nonzero exit code if anything fails

if [[ "$TRAVIS_TAG" =~ ^[0-9.]+$ ]] ; then
	tools/github-release release --security-token "$GITHUB_TOKEN" --user ePages-de --repo yaml-merge --tag "$TRAVIS_TAG" --description "Release $TRAVIS_TAG"
	tools/github-release upload --security-token "$GITHUB_TOKEN" --user ePages-de --repo yaml-merge --tag "$TRAVIS_TAG" --name yaml-merge-${TRAVIS_TAG}.zip --file build/distributions/yaml-merge-${TRAVIS_TAG}.zip
fi
