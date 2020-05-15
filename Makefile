NAME := zxvt
VMOD := ../$(NAME).vmod

$(VMOD):
	zip -r $@ . --exclude @zipexclude
