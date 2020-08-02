# Build your docker image.
sudo docker build -t starbux/api .

# Run your docker image on port 8080
sudo docker run -p 8080:8080 --rm starbux/api