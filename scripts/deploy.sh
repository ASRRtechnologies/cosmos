#!/bin/sh

if [ "$TRAVIS_BRANCH" = "main" ] && [ "$TRAVIS_PULL_REQUEST" = false ]; then
  sed -i -e 's|KUBE_CA_CERT|'"${KUBE_CA_CERT}"'|g' kubeconfig
  sed -i -e 's|KUBE_ENDPOINT|'"${KUBE_ENDPOINT}"'|g' kubeconfig
  sed -i -e 's|KUBE_ADMIN_CERT|'"${KUBE_ADMIN_CERT}"'|g' kubeconfig
  sed -i -e 's|KUBE_ADMIN_KEY|'"${KUBE_ADMIN_KEY}"'|g' kubeconfig
  sed -i -e 's|KUBE_USERNAME|'"${KUBE_USERNAME}"'|g' kubeconfig

  if [ ! -f $HOME/kubernetes/kubectl ]; then
    curl -o $HOME/kubernetes/kubectl -LO https://storage.googleapis.com/kubernetes-release/release/v1.17.3/bin/linux/amd64/kubectl
    chmod +x $HOME/kubernetes/kubectl
    $HOME/kubernetes/kubectl version --client
  fi

  $HOME/kubernetes/kubectl --kubeconfig kubeconfig rollout restart deployment/$DEPLOYMENT -n $NAMESPACE
fi
