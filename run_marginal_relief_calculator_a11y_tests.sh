#!/usr/bin/env bash
# Scalafmt checks have been separated from the test command to avoid OutOfMemoryError in Jenkins
sbt scalafmtCheckAll scalafmtSbtCheck

sbt -Dbrowser=chrome -Denvironment=local "testOnly uk.gov.hmrc.test.ui.cucumber.runner.A11yRunner"