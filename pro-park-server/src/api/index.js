const api = require('express').Router();

const authMiddleware = require('../middleware/auth');
const auth = require('./auth');
const product = require('./product');

api.use('/auth', auth);
api.use('/product', authMiddleware, product);

module.exports = api;
