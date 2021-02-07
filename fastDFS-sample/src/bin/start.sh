#!/bin/sh
APP_HOME=$(cd $(dirname $0)/..; pwd)
cd $APP_HOME
appname=fastDFS-sample-0.1.0.jar
jar=fastDFS-sample-0.1.0.jar
cmd="java -classpath $APP_HOME -jar $APP_HOME/$jar -Xms1024m -Xmx1024m --spring.profiles.active=pro"
$APP_HOME/bin/daemon.sh start ${appname} "$cmd"
