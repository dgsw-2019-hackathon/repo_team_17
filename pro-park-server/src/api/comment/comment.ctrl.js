const models = require('../../models');

// 댓글 작성
exports.createComment = async (req, res) => {
  const { memberId } = req.decoded;
  const { body } = req; // content, product_barcode
  console.log(body);
  try {
    const comment = await models.Post.createPost(memberId, body);

    if (!comment) {
      console.error('[comment - createComment] 뭔가 잘못됬습니다');
      const result = {
        status: 400,
        message: '댓글 작성 실패'
      }
  
      res.status(400).json(result);
      return;
    }

    const result = {
      status: 200,
      message: '댓글 작성 성공'
    }

    res.status(200).json(result);
  } catch (error) {
    console.error(`[comment - createComment] 서버 에러 : ${error}`);
    const result = {
      status: 500,
      message: '댓글 작성 실패'
    }

    res.status(500).json(result);
  }
};

// 대댓글 작성
exports.createReComment = async (req, res) => {

}

// 좋아요 토글
exports.toggleLike = async (req, res) => {

};

// 글 삭제
exports.deleteComment = async (req, res) => {

};

