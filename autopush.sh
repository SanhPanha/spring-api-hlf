#!/bin/bash
# Check if a commit message is provided
message=$1
if [ -z "$message" ]; then
    echo "🚨 Usage: $0 <commit message>"
    exit 1
fi

# Add all changes
echo "📂 Adding changes..."
git add .

# Commit with message
echo "📜 Committing changes..."
git commit -m "${message}"

# Push to current branch
branch=$(git branch --show-current)
echo "🚀 Pushing to origin/${branch}..."
git push -u origin "$branch"

echo "✅ Done!"
