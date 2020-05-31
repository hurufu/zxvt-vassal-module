NAME := zxvt
VMOD := ../$(NAME).vmod

JAVAC_ARGS      := -Xlint
JAVAC           := javac

JAVA_PACKAGE    := $(NAME)
JAVA_SOURCES    := $(wildcard $(JAVA_PACKAGE)/*.java)
JAVA_CLASSFILES := $(JAVA_SOURCES:.java=.class)
JAVA_CLASSPATH  := .:/usr/share/java/vassal/lib/Vengine.jar

CLASSPATH := $(JAVA_CLASSPATH)
export CLASSPATH

$(VMOD): $(JAVA_CLASSFILES)
	zip -r $@ . --exclude @zipexclude

%.class: %.java
	$(JAVAC) $(JAVAC_ARGS) $<
