#!/bin/sh

APP_HOME=$(cd "$(dirname "$0")/.."; pwd)
appname=xzDataProvider-0.0.1-SNAPSHOT.jar
$APP_HOME/bin/daemon.sh stop ${appname}
