module.exports = (sequelize, DataTypes) => {
  const Member = sequelize.define('Member', {
    id: {
      field: 'id',
      type: DataTypes.STRING(40),
      allowNull: false,
      primaryKey: true,
    },
    pw: {
      field: 'pw',
      type: DataTypes.STRING(100),
      allowNull: false,
    },
    name: {
      field: 'name',
      type: DataTypes.STRING(45),
      allowNull: false,
    },
    joinDate: {
      field: 'join_date',
      type: DataTypes.DATE,
      allowNull: false,
      defaultValue: sequelize.NOW,
    },
  }, {
    tableName: 'member',
    timestamps: false,
  });

  Member.associate = (models) => {
    Member.hasMany(models.Post , {
      foreignKey: 'writer_id',
    });
    Member.hasMany(models.Comment , {
      foreignKey: 'writer_id',
    });
    Member.hasMany(models.PostFeedback , {
      foreignKey: 'member_id',
    });
  };

  return Member;
};
