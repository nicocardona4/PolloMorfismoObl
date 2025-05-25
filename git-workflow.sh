#!/bin/bash

echo "🔁 Actualizando rama master..."
git checkout master
git pull --rebase origin master

echo "✅ Comprobando estado del repo..."
git status

echo "📦 Agregando todos los cambios..."
git add .

echo "📝 Ingresá un mensaje de commit:"
read mensaje

git commit -m "$mensaje"

echo "🔄 Haciendo pull nuevamente antes de pushear..."
git pull --rebase origin master

echo "⬆️ Subiendo cambios a origin/master..."
git push origin master

echo "🎉 Listo! Cambios subidos exitosamente."
