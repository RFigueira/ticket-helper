cleInstallation
Server with Chef
 "recipe[tecsinapse::nodejs]"
 "recipe[tecsinapse::casperjs]"

Local
 sudo su root
 //phantomjs
 npm install -g phantomjs

 //casperjs
 npm install -g casperjs

Running testes
 run tests
 casperjs test src/test/resources/casperjs/tests/*.js --ignore-ssl-errors=yes

 run tests with logs
 casperjs test src/test/resources/casperjs/tests/*.js --ignore-ssl-errors=yes --verbose --log-level=info

 run tests with profile
 casperjs test src/test/resources/casperjs/tests/*.js --ignore-ssl-errors=yes --profile=dev

 #no windows
 gitbash