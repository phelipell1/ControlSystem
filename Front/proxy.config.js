const proxy = [
  {
    context: '/rest',
    target: 'http://localhost:8080',
    pathRewrite: {'^/rest' : ''}
  }
];
module.exports = proxy;
