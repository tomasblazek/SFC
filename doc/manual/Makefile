NAME=technicka_zprava


latex: $(NAME).pdf

$(NAME).ps: $(NAME).dvi
	dvips $(NAME)

$(NAME).pdf: clean
	pdflatex $(NAME)
	-bibtex $(NAME)
	pdflatex $(NAME)
	pdflatex $(NAME)

$(NAME).dvi: $(NAME).tex $(NAME).bib
	latex $(NAME)
	-bibtex $(NAME)
	latex $(NAME)
	latex $(NAME)

vlna: $(NAME).tex
	vlna -l -m -n $(NAME).tex

zip:
	zip xblaze31.zip $(NAME).pdf

clean:
	rm -f $(NAME).dvi $(NAME).aux $(NAME).log $(NAME).blg $(NAME).bbl
