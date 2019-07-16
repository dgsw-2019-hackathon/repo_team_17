module.exports = (sequelize, DataTypes) => {
  const Product  = sequelize.define('Product', {
    barcode: {
      field: 'barcode',
      type: DataTypes.STRING(45),
      allowNull: false,
      primaryKey: true,
      autoIncreament: true,
    },
    name: {
      field: 'name',
      type: DataTypes.STRING(100),
      allowNull: false,
    },
    img: {
      field: 'img',
      type: DataTypes.STRING(1000),
      allowNull: true,
    },
  }, {
    tableName: 'product',
    timestamps: false,
  });

  Product.associate = (models) => {
    Product.hasMany(models.Post, {
      foreignKey: 'product_barcode',
    });
  };

  return Product;
};
