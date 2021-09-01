<<<<<<< HEAD:Sezin/src/test/java/com/sakuramatrix/microservicesezin/karate-config.js
  function fn(){
=======
/*
function() {
  //set up runtime variables based on environment
  //get system property 'karate.env'
  var env = karate.env;
  if (!env) { env = 'dev'; }  // default when karate.env not set
>>>>>>> d87d03dbd88b081cc68f3cd9a4b36f0b2f041c32:Sezin/src/test/java/karate-config.js

    var config = {
        baseUrl: 'http://localhost:8081'
    };

<<<<<<< HEAD:Sezin/src/test/java/com/sakuramatrix/microservicesezin/karate-config.js
    return config;
}
=======
  karate.log('karate.env =', karate.env);
  karate.log('config.baseUrl =', config.baseUrl);
  karate.log('config.apiKey =', config.apiKey);

  return config;
}*/

function fn() {

    var config = {
        baseUrl : 'http://localhost:8082'
    };

    return config;
}
>>>>>>> d87d03dbd88b081cc68f3cd9a4b36f0b2f041c32:Sezin/src/test/java/karate-config.js
