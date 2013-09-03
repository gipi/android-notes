// from  http://dl.google.com/io/2009/pres/Th_0230_TurboChargeYourUI-HowtomakeyourAndroidUIfastandefficient.pdf
static class ViewHolder {
  TextView text;
  ImageView icon;
}

public View getView(int position, View convertView, ViewGroup parent) {
  ViewHolder holder;

 if (convertView == null) {
   convertView = mInflater.inflate(R.layout.list_item_icon_text, parent, false);
   holder = new ViewHolder();
   holder.text = (TextView) convertView.findViewById(R.id.text);
   holder.icon = (ImageView) convertView.findViewById(R.id.icon);

    convertView.setTag(holder);
  } else {
    holder = (ViewHolder) convertView.getTag();
  }
 
  holder.text.setText(DATA[position]);
  holder.icon.setImageBitmap((position & 1) == 1 ? mIcon1 : mIcon2);
 
  return convertView;
}