module.exports = (sequelize, DataTypes) => {
  const Post  = sequelize.define('Post', {
    idx: {
      field: 'idx',
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    content: {
      field: 'content',
      type: DataTypes.STRING(1000),
      allowNull: false,
    },
    writeDate: {
      field: 'write_date',
      type: DataTypes.DATE,
      allowNull: false,
      defaultValue: sequelize.NOW,
    },
    productBarcode: {
      field: 'product_barcode',
      type: DataTypes.STRING(45),
      allowNull: false,
    },
    writerId: {
      field: 'writer_id',
      type: DataTypes.STRING(40),
      allowNull: false,
    },
  }, {
    tableName: 'post',
    timestamps: false,
  });

  Post.associate = (models) => {
    Post.hasMany(models.PostFeedback, {
      foreignKey: 'post_idx',
    });
    Post.hasMany(models.Comment, {
      foreignKey: 'post_idx',
    });

    Post.belongsTo(models.Member, {
      foreignKey: 'writer_id',
    });
    Post.belongsTo(models.Product, {
      foreignKey: 'product_barcode',
    });
  };

  Post.getPostByBarcode = (barcode) => Post.findAll({
    attributes: ['idx', 'content', 'writerId', 'writeDate'],
    where: {
      productBarcode: barcode,
    },
    raw: true,
  });

  Post.createPost = (memberId, data) => Post.create({
    writerId: memberId,
    content: data.content,
    productBarcode: data.productBarcode,
    writeDate: new Date(),
  });

  return Post;
};
