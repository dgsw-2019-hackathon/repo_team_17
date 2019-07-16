module.exports = (sequelize, DataTypes) => {
  const Member = sequelize.define('Member', {
    id: {
      field: 'id',
      type: DataTypes.STRING,
      allowNull: false,
      primaryKey: true,
    },
    pw: {
      field: 'pw',
      type: DataTypes.STRING,
      allowNull: false,
    },
    name: {
      field: 'name',
      type: DataTypes.STRING,
      allowNull: false,
    },
    joinDate: {
      field: 'join_date',
      type: DataTypes.DATE,
      allowNull: false,
      defaultValue: DataTypes.NOW,
    },
  }, {
    tableName: 'member',
    timestamps: false,
  });

  Member.associate = (models) => {
    Member.hasMany(models.Comment , {
      foreignKey: 'member_id',
    });
  };

  return Member;
};
