module.exports = function (grunt) {
	grunt.initConfig({
		watch: {
			fest: {
				files: ['templates/*.xml'],
				task: ['fest'],
				options: {
					atBegin: true
				}
			},
			server: {
				files: [
				'public_html/js/**/*.js', // следим за статикой
				'public_html/css/**/*.css'
				],
				options: {
					interrupt: true,
					livereload: true // перезагрузить страницу
				}
			}
		},
		shell: {
			options: {
				stdout: true,
				stderr: true
			},
			server: {
				command: 'java -cp out/artifacts/first_jar/first.jar main.Main 8080' /* запуск сервера */
			}
		},
		fest: {
			templates: {
				files: [{
					expand: true,
					cwd: 'templates', // исходная директория
					src: '*xml',
					dest: 'public_html/js/tmpl'
				}],
				options: {
					templates: function (data) { // задаем формат функции шаблна
						return grunt.template.process(
							'var <%= name %>Tmpl = <%= contents %> ;', // присваеваем функцию-шаблон переменной
							{data: data}
							);
					}
				}
			}
		},
		concurrent: {
			targert: ['watch', 'shell'],
			options: {
				logConcurrentOutput: true // output logs
			}
		}
	});

	grunt.loadNpmTasks('grunt-contrib-watch');
	grunt.loadNpmTasks('grunt-concurrent');
	grunt.loadNpmTasks('grunt-shell');
	grunt.loadNpmTasks('grunt-fest');

	grunt.registerTask('default', ['concurrent']);
};