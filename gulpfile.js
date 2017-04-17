var gulp = require('gulp');
const tslint = require('gulp-tslint');
const prettyTypescript = require('pretty-typescript');

gulp.task('tslint', () => {
    return gulp.src("src/**/*.ts")
        .pipe(tslint({
            formatter: 'prose'
        }))
        .pipe(tslint.report());
});



gulp.task('watch', function () {
    gulp.watch(["src/**/*.ts"], ['tslint']).on('change', function (e) {
        console.log('TypeScript file ' + e.path + ' has been changed. TsLinting/prettify.');
    });
});

gulp.task('default', ['tslint', 'watch']);
