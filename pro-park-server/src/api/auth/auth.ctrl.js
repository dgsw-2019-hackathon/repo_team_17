

/**
 * @description 로그인 처리
 */
exports.login = async (req, res) => {
  const { body } = req;

  try {
    // 로그인 처리
  } catch (error) {
    console.log(`[auth - login] 서버에러 : ${error}`);
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
exports.logout = (req, res) => {
  res.send('asd');
};
