var webpack = require("webpack");

var config = {
    entry: "./src/main/client/main.js",

    output: {
        filename: "bundle.js",
        path: "./src/main/resources/static/",
    },
    module: {
        loaders: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                loader: 'babel-loader',
                query: {
                    presets: ['react', 'es2015']
                }
            }
        ],
    },
        plugins: [
    new webpack.ProvidePlugin({
        $: "jquery",
        jQuery: "jquery"
    })
]
};
module.exports = config;