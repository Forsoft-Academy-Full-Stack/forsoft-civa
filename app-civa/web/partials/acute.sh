#!/bin/bash

# Modificando os acentos para o padrão universal acute para que não ocorra problema ao importar o projeto.
sudo sed -i  's/á/\&aacute;/' *.jsp
sudo sed -i  's/Á/\&Aacute;/' *.jsp
sudo sed -i  's/ã/\&atilde;/' *.jsp
sudo sed -i  's/Ã/\&Atilde;/' *.jsp
sudo sed -i  's/â/\&acirc;/' *.jsp
sudo sed -i  's/Â/\&Acirc;/' *.jsp
sudo sed -i  's/ª/\&aring;/' *.jsp

sudo sed -i  's/é/\&eacute;/' *.jsp
sudo sed -i  's/É/\&Eacute;/' *.jsp
sudo sed -i  's/ê/\&ecirc;/' *.jsp
sudo sed -i  's/Ê/\&Ecirc;/' *.jsp
sudo sed -i  's/è/\&egrave;/' *.jsp
sudo sed -i  's/È/\&Egrave;/' *.jsp

sudo sed -i  's/í/\&iacute;/' *.jsp
sudo sed -i  's/Í/\&Iacute;/' *.jsp

sudo sed -i  's/ó/\&oacute;/' *.jsp
sudo sed -i  's/Ó/\&Oacute;/' *.jsp
sudo sed -i  's/õ/\&otilde;/' *.jsp
sudo sed -i  's/Õ/\&Otilde;/' *.jsp
sudo sed -i  's/ô/\&ocirc;/' *.jsp
sudo sed -i  's/Ô/\&Ocirc;/' *.jsp
sudo sed -i  's/ò/\&ograve;/' *.jsp
sudo sed -i  's/Ò/\&Ograve;/' *.jsp
sudo sed -i  's/º/\&oring;/' *.jsp

sudo sed -i  's/ú/\&uacute;/' *.jsp
sudo sed -i  's/Ú/\&Uacute;/' *.jsp
sudo sed -i  's/û/\&ucirc;/' *.jsp
sudo sed -i  's/Û/\&Ucirc;/' *.jsp
sudo sed -i  's/ũ/\&utilde;/' *.jsp
sudo sed -i  's/Ũ/\&Utilde;/' *.jsp

sudo sed -i  's/ç/\&ccedil;/' *.jsp
sudo sed -i  's/Ç/\&Ccedil;/' *.jsp

sudo sed -i  's/©/\&copy;/' *.jsp




