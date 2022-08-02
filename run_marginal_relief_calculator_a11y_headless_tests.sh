#!/bin/bash -e
DEFAULT_BROWSER=remote-chrome
BROWSER_TYPE=$1
ENV=$2

if [ -z "$BROWSER_TYPE" ]; then
    echo "BROWSER_TYPE value not set, defaulting to $DEFAULT_BROWSER..."
    echo ""
fi

sbt -jvm-debug 5005 -Dbrowser=$BROWSER -Denvironment=$ENV $DRIVER "testOnly uk.gov.hmrc.test.ui.cucumber.runner.A11yRunner"