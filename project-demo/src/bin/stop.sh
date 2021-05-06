`#!/bin/sh

APP_HOME=$(cd "$(dirname "$0")/.."; pwd)
appname=projectDemo.jar
$APP_HOME/bin/daemon.sh stop ${appname}
