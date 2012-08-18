#! /bin/bash

cd $CATALINA_HOME
./bin/shutdown.sh
rm *.xlsx
cd $CATALINA_BASE
rm -r temp
rm -r work
rm -r webapps/billing*
rm -r logs/*
cp $PROJECTS/billing/billing/target/billing*.war $CATALINA_BASE/webapps
cd $CATALINA_HOME
./bin/startup.sh
exit