#!/bin/bash -e

BROWSER=$1
ENVIRONMENT=$2
DAST=${3:-false}


if ($DAST); then
  export ZAP_FORWARD_ENABLE="true"
  export ZAP_FORWARD_PORTS=$(lsof -i -P | grep LISTEN | grep :$PORT | grep java | awk '{ print $9}' | sed 's/\*://g' | paste -sd " " -)

  export ZAP_LOCAL_ALERT_FILTERS="${PWD}/alert-filters.json"

  (
    cd $WORKSPACE/dast-config-manager
    make local-zap-running
  )

  echo "started dast-config-manager"
  echo "=========================================="
  echo "Browser:              ${BROWSER}"
  echo "Env:                  ${ENVIRONMENT}"
  echo "ZAP Proxy Required:   true"
  echo "ZAP alert filters:    ${ZAP_LOCAL_ALERT_FILTERS}"
  echo "=========================================="
fi

sbt clean -Dbrowser="${BROWSER:=chrome}" -Denvironment="${ENVIRONMENT:=local}" -Dsecurity.assessment="${DAST}" "testOnly uk.gov.hmrc.test.ui.specs.*" testReport

if ($DAST); then
  echo "stopping dast-config-manager"
  (
    cd $WORKSPACE/dast-config-manager
    make local-zap-stop
  )
  cd -
fi