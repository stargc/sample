#!/bin/sh
APP_HOME=$(cd $(dirname $0)/..; pwd)
cd $APP_HOME
appname=tpsWorkbench-0.0.1-SNAPSHOT.jar
jar=tpsWorkbench-0.0.1-SNAPSHOT.jar
cmd="java -classpath $APP_HOME -jar $APP_HOME/$jar -Xms1024m -Xmx1024m"
$APP_HOME/bin/daemon.sh start ${appname} "$cmd"
