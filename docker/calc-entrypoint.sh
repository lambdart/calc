#!/bin/sh

set -x;

# install dependencies and execute with dev environment
entrypoint ()
{
    clj -M:env/dev-docker
}

entrypoint
