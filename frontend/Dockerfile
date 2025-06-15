FROM nginx:alpine

# Copia o arquivo de configuração do Nginx
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Copia os arquivos estáticos
COPY index.html /usr/share/nginx/html/
COPY 502.html /usr/share/nginx/html/
COPY js /usr/share/nginx/html/js
COPY css /usr/share/nginx/html/css

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"] 