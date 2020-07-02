module.exports = {
    pages : {
        about : {
            entry : 'src/pages/about/about.js',
            template : 'public/pages/about.html',
            filename : 'templates/about.html',
            title : 'About Page',
            chunks : [ 'chunk-vendors', 'chunk-common', 'about' ]
        },
        home : {
            entry : 'src/pages/home/home.js',
            template : 'public/pages/home.html',
            filename : 'templates/home.html',
            title : 'Home Page',
            chunks : [ 'chunk-vendors', 'chunk-common', 'home' ]
        }
    }
}