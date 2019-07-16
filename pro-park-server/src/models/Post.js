module.exports = (sequelize, DataTypes) => {
  const Post  = sequelize.define('Post', {
    idx: {
      field: 'idx',
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true,
      autoIncreament: true,
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

  return Post;
};
