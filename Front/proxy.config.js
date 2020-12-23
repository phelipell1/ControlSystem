const proxy = [
  {
    context: '/rest',
    target: 'http://localhost:8080'
  }
];
module.exports = proxy;
