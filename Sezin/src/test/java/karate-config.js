/*
function() {
  //set up runtime variables based on environment
  //get system property 'karate.env'
  var env = karate.env;
  if (!env) { env = 'dev'; }  // default when karate.env not set

  // base config
  var config = {
    env: env,
    baseUrl: 'https://localapi.abc123.example.com/api/v1/validate/customerid',
    apiKey: ''
  }
  //switch environment
  if (env == 'dev') {
  config.baseUrl = 'https://devapi.abc123.example.com/api/v1/validate/customerid';
  config.apiKey  = 'fake-1ba403ca8938176f3a62de6d30cfb8e';
  }
  else if (env == 'qual') { //Pre-production environment settings
  config.baseUrl = 'https://qualapi.abc123.example.com/api/v1/validate/customerid';
  config.apiKey  = 'fake-d5de2eb8c0920537f5488f6535c139f2';
  }

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
