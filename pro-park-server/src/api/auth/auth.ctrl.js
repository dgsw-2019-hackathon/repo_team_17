const models = require('../../models');
const lib = require('../../lib/token');

/**
 * @description 로그인 처리
 */
exports.login = async (req, res) => {
  const { body } = req;

  try {
    const member = await models.Member.userLogin(body);

    if (!member) {
      const result = {
        status: 400,
        message: '존재하지 않는 회원입니다'
      };

      res.status(400).json(result);
      return;
    }

    const token = await lib.createToken(member.id, member.name);

    const result = {
      status: 200,
      message: '로그인 성공',
      token,
    };

    res.status(200).json(result);
  } catch (error) {
    console.error(`[auth - login] 서버에러 : ${error}`);
    const result = {
      status: 500,
      message: '로그인에 실패했습니다'
    };

    res.status(500).json(result);
  }
};

/**
 * @description 회원가입 처리
 */
exports.signup = (req, res) => {
  res.send('asd');
};
