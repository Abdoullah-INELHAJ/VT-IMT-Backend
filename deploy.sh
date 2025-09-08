#!/bin/bash
set -e

LOGFILE=/home/user/deploy.log

echo "=== Déploiement $(date) ===" | tee -a $LOGFILE

# 1. Récupération du code depuis GitHub
echo "[1/5] Clonage du repo..." | tee -a $LOGFILE
if [ ! -d "vt-imt-backend" ]; then
  git clone https://github.com/Abdoullah-INELHAJ/VT-IMT-Backend.git >> $LOGFILE 2>&1
else
  cd vt-imt-backend
  git pull origin main >> $LOGFILE 2>&1
  cd ..
fi

cd vt-imt-backend

# 2. Compilation + Tests
echo "[2/5] Compilation + tests Maven..." | tee -a $LOGFILE
mvn clean package >> $LOGFILE 2>&1

# 3. Build image Docker
echo "[3/5] Construction image Docker..." | tee -a $LOGFILE
docker build -t vt-imt-backend . >> $LOGFILE 2>&1

# 4. Run container
echo "[4/5] Déploiement du conteneur..." | tee -a $LOGFILE
docker stop vt-imt-backend || true
docker rm vt-imt-backend || true
docker run -d -p 8080:8080 --name vt-imt-backend vt-imt-backend >> $LOGFILE 2>&1

# 5. Fin
echo "[5/5] Déploiement terminé " | tee -a $LOGFILE
