#!/bin/sh

APP_HOME=$(cd "$(dirname "$0")/.."; pwd)
appname=fastDFS-sample-0.1.0.jar
$APP_HOME/bin/daemon.sh stop ${appname}
