const router = require('express').Router();
const authCtrl = require('./auth.ctrl');

router.route('/login').post(authCtrl.login);
router.route('/logout').post(authCtrl.logout);

module.exports = router;
