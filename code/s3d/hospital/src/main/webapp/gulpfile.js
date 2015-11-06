var gulp = require('gulp');
var minifycss = require('gulp-minify-css'),
    uglify = require('gulp-uglify'),
    concat = require('gulp-concat'),
    rename = require('gulp-rename'),
    del = require('del');

// builder.css
gulp.task('css-builder', function () {
    return gulp.src(['styles/css/main.css'])
        /*.pipe(concat('builder.min.css'))
        .pipe(gulp.dest('styles/'))*/
        .pipe(rename('builder.min.css'))
        .pipe(minifycss())
        .pipe(gulp.dest('styles/css/'));
});

// builder.js
gulp.task('js-builder', function () {
    return gulp.src(['scripts/**/*.js', '!/scripts/builder.min.js', '!/scripts/lib.min.js'])
        .pipe(concat('builder.min.js'))
        /*.pipe(gulp.dest('scripts/'))
        .pipe(rename({suffix: '.min'}))*/
        .pipe(uglify())
        .pipe(gulp.dest('scripts/'));
});

// lib.css
gulp.task('css-lib', function () {
    return gulp.src([
        'vendor/bootstrap/dist/css/bootstrap.min.css',
        'vendor/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css',
        'vendor/blueimp-file-upload/css/jquery.fileupload.css',
        'vendor/jcrop/css/Jcrop.min.css',
        'vendor/angular-ui-select/dist/select.css',
        'styles/css/selectize.default.css'
    ])
        .pipe(concat('lib.min.css'))
        //.pipe(rename({suffix: '.min'}))
        .pipe(minifycss())
        .pipe(gulp.dest('styles/css/'));
});

// lib.js
gulp.task('js-lib', function () {
    return gulp.src([
        'vendor/jquery/dist/jquery.min.js',
        'vendor/angular/angular.min.js',
        'vendor/angular-ui-router/release/angular-ui-router.min.js',
        'vendor/angular-sanitize/angular-sanitize.js',
        'vendor/bootstrap/dist/js/bootstrap.min.js',
        'vendor/moment/min/moment.min.js',
        'vendor/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js',
        'vendor/lodash/dist/lodash.min.js',
        'vendor/jquery-ui/jquery-ui.min.js',
        'vendor/blueimp-file-upload/js/vendor/jquery.ui.widget.js',
        'vendor/blueimp-file-upload/js/jquery.fileupload.js',
        'vendor/angular-ui-sortable/sortable.min.js',
        'vendor/jcrop/js/Jcrop.min.js',
        'vendor/angular-ui-select/dist/select.js',
        'vendor/interact/interact.min.js'
    ])
        .pipe(concat('lib.min.js'))
        //.pipe(rename({suffix: '.min'}))
        .pipe(uglify())
        .pipe(gulp.dest('scripts/'));
});

gulp.task('clean', function (cb) {
    del(['scripts/builder.min.js', 'scripts/lib.min.js', 'styles/builder.min.css', 'styles/lib.min.css'], cb);
});

gulp.task('product', function () {
    gulp.watch(['scripts/**/*.js', '!scripts/builder.min.js', '!scripts/lib.min.js'], ['js-builder']);
    gulp.watch(['styles/**/*.css', '!styles/builder.min.css', '!styles/lib.min.css'], ['css-builder']);
});

gulp.task('default', ['clean'], function () {
    gulp.start(['css-builder', 'js-builder', 'css-lib', 'js-lib']);
    //gulp.start(['css-builder', 'js-builder', 'css-lib']);
    //gulp.start('product');
});