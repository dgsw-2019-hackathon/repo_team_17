module.exports = (sequelize, DataTypes) => {
  const PostFeedback  = sequelize.define('PostFeedback', {
    idx: {
      field: 'idx',
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true,
      autoIncreament: true,
    },
    good: {
      field: 'good',
      type: DataTypes.INTEGER,
      allowNull: false,
      defaultValue: 0,
    },
    postIdx: {
      field: 'post_idx',
      type: DataTypes.INTEGER,
      allowNull: false,
    },
    memberId: {
      field: 'member_id',
      type: DataTypes.STRING(40),
      allowNull: false,
    },
  }, {
    tableName: 'post_feedback',
    timestamps: false,
  });

  PostFeedback.associate = (models) => {
    PostFeedback.belongsTo(models.Member, {
      foreignKey: 'member_id',
    });
    PostFeedback.belongsTo(models.Post, {
      foreignKey: 'post_idx',
    });
  };

  return PostFeedback;
};
